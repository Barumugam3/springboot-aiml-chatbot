package com.sample.services;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.MagicBooleans;
import org.alicebot.ab.MagicStrings;
import org.springframework.stereotype.Service;

import com.sample.utils.ResourcesLocation;

@Service
public class ChatbotUtilService {
	private static final boolean TRACE_MODE = false;
	static String botName = "super";

	@SuppressWarnings("rawtypes")
	public String getBotResponse(String userReq) {
		String response = null;
		try {
			ResourcesLocation resource = new ResourcesLocation();
			String resourcesPath = resource.getResourcesPath();
			MagicBooleans.trace_mode = TRACE_MODE;
			Bot bot = new Bot("super", resourcesPath);
			Chat chatSession = new Chat(bot);
			bot.brain.nodeStats();
			//String textLine = "";

			//while (true) {
				//System.out.print("Human : ");
				//textLine = IOUtils.readInputTextLine();
				if ((userReq == null) || (userReq.length() < 1))
					userReq = MagicStrings.null_input;
				if (userReq.equals("quit")) {
					System.exit(0);
				} else {
					String request = userReq;
					/*if (MagicBooleans.trace_mode)
						System.out.println(
								"STATE=" + request + ":THAT=" + ((History) chatSession.thatHistory.get(0)).get(0)
										+ ":TOPIC=" + chatSession.predicates.get("topic"));*/
					response = chatSession.multisentenceRespond(request);
					while (response.contains("&lt;"))
						response = response.replace("&lt;", "<");
					while (response.contains("&gt;"))
						response = response.replace("&gt;", ">");
					//System.out.println("Robot : " + response);
				}
			//}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}