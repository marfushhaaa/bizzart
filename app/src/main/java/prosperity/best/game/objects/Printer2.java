package prosperity.best.game.objects;

import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Printer2 {
    public static void printText(final Word2 word, final TextView textView, final ImageView butt) {
        butt.setEnabled(false);
        Random random = new Random(System.currentTimeMillis());
        int currentRandOffset = random.nextInt(word.offset);
        boolean addOrSubtract = random.nextBoolean();
        long finalDelay = addOrSubtract ? word.delayBetweenSymbols + currentRandOffset : word.delayBetweenSymbols - currentRandOffset;
        if (finalDelay < 0) finalDelay = 0;
        if(word.currentCharacterIndex == 0) {
            textView.setText("");
            butt.setEnabled(true);

        }
        textView.postDelayed(new Runnable() {
            @Override
            public void run() {
                String charAt = String.valueOf(word.word.charAt(word.currentCharacterIndex));
                ++word.currentCharacterIndex;
                textView.setText(textView.getText() + charAt);
                if (word.currentCharacterIndex >= word.word.length()) return;

                printText(word, textView, butt);
            }
        }, finalDelay);
    }


    public static class Word2 {

        private long delayBetweenSymbols;

        private String word;
        private int offset;
        private int currentCharacterIndex;

        public Word2(long delayBetweenSymbols, String word) {
            if (delayBetweenSymbols < 0) throw new IllegalArgumentException("Delay can't be < 0");

            this.delayBetweenSymbols = delayBetweenSymbols;
            this.word = word;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }
    }
}
