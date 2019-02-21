/**
 * 
 */
package it.unifi.rc.httpserver.test.m5793664.server;

import static org.junit.Assert.fail;

import java.io.File;
import java.net.InetAddress;
import java.util.Date;

import org.junit.Test;

import it.unifi.rc.httpserver.HTTPHandler;
import it.unifi.rc.httpserver.HTTPServer;
import it.unifi.rc.httpserver.m5793664.handlers.MyHTTPHandler1_0;
import it.unifi.rc.httpserver.m5793664.server.MyHTTPServer;

public class MyHttpServerLauncher {
	private HTTPServer server;

	@Test
	public void test() {
		int millisec = 600000;
		int minutes = (int) ((millisec / (1000*60)) % 60);
		try {
			server = new MyHTTPServer(12000, 10, InetAddress.getByName("127.0.0.1"), createChain());
			System.out.println("Starting server... on: " + new Date() + ". It will be online for: "  + minutes + " min");
			server.start();
			System.out.println("Server v1 online!");
			Thread.sleep(millisec);
			server.stop();
			System.out.println("Server Stopped!");
		} catch (Exception e) {
			System.out.println("ERROR - Something went wrong!");
			e.getMessage();
			e.printStackTrace();
			fail();
		}
	}

	private static HTTPHandler[] createChain() {
		File root = new File("myroots/server");
		if (!root.exists()) {
			root.mkdir();
		}
		MyHTTPHandler1_0 pippo = new MyHTTPHandler1_0(root, "pippo.com");
		MyHTTPHandler1_0 example = new MyHTTPHandler1_0(root, "example.com");
		MyHTTPHandler1_0 all = new MyHTTPHandler1_0(root);

		return new MyHTTPHandler1_0[] { pippo, example, all };
	}

}
