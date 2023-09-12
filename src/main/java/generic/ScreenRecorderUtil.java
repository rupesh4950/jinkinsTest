package generic;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import extentReporter.ExtentConfig;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class ScreenRecorderUtil extends ScreenRecorder {
	public String name;
	public static String filePath;
	public ScreenRecorderUtil(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat, Format screenFormat,
			Format mouseFormat, Format audioFormat, File movieFolder, String name) throws IOException, AWTException {
		super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
		this.name = name;
	}

	@Override
	protected File createMovieFile(Format fileFormat) throws IOException {

		if (!movieFolder.exists()) {
			movieFolder.mkdirs();
		} else if (!movieFolder.isDirectory()) {
			throw new IOException("\"" + movieFolder + "\" is not a directory.");
		}
		return new File(movieFolder, name + "." + Registry.getInstance().getExtension(fileFormat));
	}

	public static ScreenRecorderUtil startRecord(String methodName) throws Exception {
		//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String dateFormat = getCurrentDateAndTime();
		 filePath="./test-recordings/Suite"+ExtentConfig.getDateTime();
		File file = new File(filePath);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
//  System.out.println(methodName+"  in screensRecorder");
		Rectangle captureSize = new Rectangle(0, 0, width, height);

		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();
		ScreenRecorderUtil screenRecorder = new ScreenRecorderUtil(gc, captureSize,
				new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
						CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
						Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
				null, file, methodName);
		screenRecorder.start();
		return screenRecorder;
	}

	public static void stopRecord(ScreenRecorderUtil screenRecorder) throws Exception {
		screenRecorder.stop();
	}
	public static String getCurrentDateAndTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MM_yyyy hh-mm-ss a")).toUpperCase();
	}
}
