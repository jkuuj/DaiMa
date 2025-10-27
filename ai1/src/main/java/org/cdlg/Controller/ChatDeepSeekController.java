package org.cdlg.Controller;
import org.springframework.ai.deepseek.DeepSeekChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ChatDeepSeekController {
    @Autowired
    private DeepSeekChatModel chatModel;
    @GetMapping("/ai/generate")
    public String generate(@RequestParam(value = "message", defaultValue =
            "hello")
                           String message) {
        String response = this.chatModel.call(message);
        System.out.println("response : "+response);
        return response;
    }
}
