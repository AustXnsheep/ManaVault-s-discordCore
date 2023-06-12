package austxnsheep.main.verification;

import java.util.Random;

public class VerificationCore {
    public String giveRandomCode() {
        Random random = new Random();
        int code = 0;
        for (int i = 0; i < 10; i++) {
            code = code * 10 + random.nextInt(10);
        }
        return String.valueOf(code);
    }
}
