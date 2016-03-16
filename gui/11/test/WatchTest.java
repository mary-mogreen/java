/**
 *
 */
package test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import src.Watch;


/**
 * @author mary-mogreen
 * 閉じるボタンを押すテスト（できてない）
 */
public class WatchTest {

	@Rule
	public final ExpectedSystemExit exit = ExpectedSystemExit.none();

	@Test
	public void testCloseButton() throws AWTException {
		exit.expectSystemExitWithStatus(0);
		Watch.main(null);

        Robot robot = new Robot();

        robot.mouseMove(270, 15);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
  	}

}
