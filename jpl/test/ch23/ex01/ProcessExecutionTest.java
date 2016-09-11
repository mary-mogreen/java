package ch23.ex01;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

import org.junit.Test;

public class ProcessExecutionTest {

	@Test
	public void ls_test() {
		String opts = "-al";
		String dir = "";
		String[] result;
		
		try {
			result = ProcessExecution.ls(dir, opts);
			
			try {
				Process proc = ProcessExecution.userProg("ls -al");
				InputStream lsOut = proc.getInputStream();
				InputStreamReader r = new InputStreamReader(lsOut);
				BufferedReader in = new BufferedReader(r);
				String line;
				int i;
				for (i = 0; (line = in.readLine()) != null; i++) {
					assertThat(Objects.equals(line, result[i]), is(true));
					System.out.println(line);
				}
				if (i < result.length)
					fail();
			} catch (IOException e) {
				e.printStackTrace();
				fail("userProg ls failed.");
			}
		} catch (LSFailedException e) {
			e.printStackTrace();
			fail("ls failed.");
		}
		
		
	}

}
