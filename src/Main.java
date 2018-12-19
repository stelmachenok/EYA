
import javax.sound.sampled.*;
import java.io.File;
import java.io.SequenceInputStream;
import java.util.*;

public class Main {

    private static List<Double> listLengths = new ArrayList<>();
    private static List<String> phonemStringList;

    static class ReadList implements Runnable{
        @Override
        public void run() {
            System.out.println("Произношение: ");
            for (int i = 0; i < phonemStringList.size(); i++) {
                try {
                    System.out.print(phonemStringList.get(i));
                    java.lang.Thread.sleep((long) (listLengths.get(i)*1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        List<Character> lettersList = new ArrayList<>();
        List<Character> phoneticList = new ArrayList<>();
        List<String> soundsList = new ArrayList<>();
        phonemStringList = new ArrayList<>();
        Map<String, String> soundsMap = new HashMap<>();
        List<String> consolantList = new ArrayList<>();
        List<String> unpairedHardConsolant = new ArrayList<>();







        Map<String, String> voiceToDeafConsonants = new HashMap<>();
        voiceToDeafConsonants.put("б", "п");
        voiceToDeafConsonants.put("в", "ф");
        voiceToDeafConsonants.put("г", "к");
        voiceToDeafConsonants.put("д", "т");
        voiceToDeafConsonants.put("ж", "ш");
        voiceToDeafConsonants.put("з", "с");
        voiceToDeafConsonants.put("б'", "п'");
        voiceToDeafConsonants.put("в'", "ф'");
        voiceToDeafConsonants.put("г'", "к'");
        voiceToDeafConsonants.put("д'", "т'");
        voiceToDeafConsonants.put("з'", "с'");

        Map<String, String> deafToVoiceConsonants = new HashMap<>();
        deafToVoiceConsonants.put("п", "б");
        deafToVoiceConsonants.put("ф", "в");
        deafToVoiceConsonants.put("к", "г");
        deafToVoiceConsonants.put("т", "д");
        deafToVoiceConsonants.put("ш", "ж");
        deafToVoiceConsonants.put("с", "з");
        deafToVoiceConsonants.put("п'", "б'");
        deafToVoiceConsonants.put("ф'", "в'");
        deafToVoiceConsonants.put("к'", "г'");
        deafToVoiceConsonants.put("т'", "д'");
        deafToVoiceConsonants.put("с'", "з'");


        List<String> nonVoiceVowels = new ArrayList<>();
        nonVoiceVowels.add("а");
        nonVoiceVowels.add("о");
        nonVoiceVowels.add("у");
        nonVoiceVowels.add("э");
        nonVoiceVowels.add("ы");
        nonVoiceVowels.add("и");

        List<String> voiceVowels = new ArrayList<>();
        voiceVowels.add("А");
        voiceVowels.add("О");
        voiceVowels.add("У");
        voiceVowels.add("Э");
        voiceVowels.add("Ы");
        voiceVowels.add("И");


      List<String> vowels = new ArrayList<>();
      vowels.add("а");
      vowels.add("о");
      vowels.add("у");
      vowels.add("э");
      vowels.add("ы");
      vowels.add("и");
      vowels.add("е");
      vowels.add("ё");
      vowels.add("ю");
      vowels.add("я");
      vowels.add("А");
      vowels.add("О");
      vowels.add("У");
      vowels.add("Э");
      vowels.add("Ы");
      vowels.add("И");
      vowels.add("Е");
      vowels.add("Ё");
      vowels.add("Ю");
      vowels.add("Я");






        



        // смягчающиеся
        consolantList.add("б");
        consolantList.add("в");
        consolantList.add("г");
        consolantList.add("д");
        consolantList.add("л");
        consolantList.add("м");
        consolantList.add("н");
        consolantList.add("р");
        consolantList.add("п");
        consolantList.add("к");
        consolantList.add("т");
        consolantList.add("з");
        consolantList.add("ф");
        consolantList.add("с");
        consolantList.add("щ");
        consolantList.add("х");
        consolantList.add("ч");

        unpairedHardConsolant = new ArrayList<>();
        unpairedHardConsolant.add("ж");
        unpairedHardConsolant.add("ш");
        unpairedHardConsolant.add("ц");

        soundsMap.put("А", "src/sounds_max/а2.wav");
        soundsMap.put("О", "src/sounds_max/о.wav");
        soundsMap.put("У", "src/sounds_max/у.wav");
        soundsMap.put("Э", "src/sounds_max/э.wav");
        soundsMap.put("Ы", "src/sounds_max/ы.wav");
        soundsMap.put("И", "src/sounds_max/и.wav");
        soundsMap.put("а", "src/sounds_max/а2.wav");
        soundsMap.put("б", "src/sounds_max/б.wav");
        soundsMap.put("в", "src/sounds_max/в.wav");
        soundsMap.put("г", "src/sounds_max/г.wav");
        soundsMap.put("д", "src/sounds_max/д.wav");
        soundsMap.put("ж", "src/sounds_max/ж.wav");
        soundsMap.put("з", "src/sounds_max/з.wav");
        soundsMap.put("и", "src/sounds_max/и.wav");
        soundsMap.put("к", "src/sounds_max/к.wav");
        soundsMap.put("л", "src/sounds_max/л.wav");
        soundsMap.put("м", "src/sounds_max/м.wav");
        soundsMap.put("н", "src/sounds_max/н.wav");
        soundsMap.put("о", "src/sounds_max/о.wav");
        soundsMap.put("п", "src/sounds_max/п.wav");
        soundsMap.put("р", "src/sounds_max/р.wav");
        soundsMap.put("с", "src/sounds_max/с.wav");
        soundsMap.put("т", "src/sounds_max/т.wav");
        soundsMap.put("у", "src/sounds_max/у.wav");
        soundsMap.put("ф", "src/sounds_max/ф.wav");
        soundsMap.put("х", "src/sounds_max/х.wav");
        soundsMap.put("ц", "src/sounds_max/ц.wav");
        soundsMap.put("ч", "src/sounds_max/ч.wav");
        soundsMap.put("щ", "src/sounds_max/щ.wav");
        soundsMap.put("ш", "src/sounds_max/ш.wav");
        soundsMap.put("э", "src/sounds_max/э.wav");
        soundsMap.put("ы", "src/sounds_max/ы.wav");
        soundsMap.put(" ", "src/sounds_max/silence.wav");
        soundsMap.put("й", "src/sounds_max/й.wav");
        soundsMap.put("л'", "src/sounds_max/ль.wav");
        soundsMap.put("м'", "src/sounds_max/мь.wav");
        soundsMap.put("н'", "src/sounds_max/нь.wav");
        soundsMap.put("р'", "src/sounds_max/рь.wav");
        soundsMap.put("п'", "src/sounds_max/пь.wav");
        soundsMap.put("к'", "src/sounds_max/кь.wav");
        soundsMap.put("т'", "src/sounds_max/ть.wav");
        soundsMap.put("в'", "src/sounds_max/вь.wav");
        soundsMap.put("з'", "src/sounds_max/зь.wav");
        soundsMap.put("б'", "src/sounds_max/бь.wav");
        soundsMap.put("д'", "src/sounds_max/дь.wav");
        soundsMap.put("г'", "src/sounds_max/гь.wav");
        soundsMap.put("ф'", "src/sounds_max/фь.wav");
        soundsMap.put("с'", "src/sounds_max/сь.wav");
        soundsMap.put("щ'", "src/sounds_max/щ.wav");
        soundsMap.put("х'", "src/sounds_max/хь.wav");
        soundsMap.put("ч'", "src/sounds_max/ч.wav");


        boolean voiceModeOn = false;
        System.out.println("Хотите использовать режим с ударениями?");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String answer = input.toLowerCase();
        if (answer.contains("y") || answer.contains("д")){
            voiceModeOn = true;
        }

        System.out.println("Введите текст:");
        input = scanner.nextLine();


//        У менестрЕля двА путИ корпоратИв Или квартИрник
//      вьЮга  молокО  объём  Яма  поёт  тЮк  лёд  пЯть  сЕмь  тянУть  дЕрево  жИть  шИть
//      вьюга  молоко  объём  яма  поёт  тюк  лёд  пять  семь  тянуть  дерево  жить  шить
//      Я солдАт недонОшенный ребЁнок войнЫ, Я солдАт, мАма залечИ моИ рАны


//      Оо- моя оборона
//      Солнечный зайчик стеклянного глаза
//      Оо- моя оборона
//      Траурный мячик нелепого мира
//      Траурный мячик дешёвого мира

      String phoneticString = input
                .replaceAll("Б","б")
                .replaceAll("В","в")
                .replaceAll("Г","г")
                .replaceAll("Д","д")
                .replaceAll("Ж","ж")
                .replaceAll("З","з")
                .replaceAll("Й","й")
                .replaceAll("К","к")
                .replaceAll("Л","л")
                .replaceAll("М","м")
                .replaceAll("Н","н")
                .replaceAll("П","п")
                .replaceAll("Р","р")
                .replaceAll("С","с")
                .replaceAll("Т","т")
                .replaceAll("Ф","ф")
                .replaceAll("Х","х")
                .replaceAll("Ц","ц")
                .replaceAll("Ч","ч")
                .replaceAll("Ш","ш")
                .replaceAll("Щ","щ")
                .replaceAll("Ъ","ъ")
                .replaceAll("Ь","ь")
//                .replaceAll("я","йа")
//                .replaceAll("е", "йэ")
//                .replaceAll("ю","йу")
//                .replaceAll("ё", "йо")
                .replaceAll(",", " ")
                .replaceAll("-", " ")
                .replaceAll(":", " ")
                .replaceAll("\\.", "  ");

        if (voiceModeOn) {
            phoneticString = phoneticString
                .replaceAll("о", "а")
                .replaceAll("е", "и");
        }

        for (int i = 0; i < input.length(); i++) {
            lettersList.add(input.charAt(i));
        }

        //System.out.println(""+lettersList);

        for (int i = 0; i < phoneticString.length(); i++) {
            phoneticList.add((phoneticString.charAt(i)));
        }

        for (Character aPhoneticList : phoneticList) {
            phonemStringList.add(aPhoneticList.toString());
        }

      if (phonemStringList.get(0).equalsIgnoreCase("e")) {
        phonemStringList.set(0, "э");
        phonemStringList.add(0, "й");
      }
      if (phonemStringList.get(0).equalsIgnoreCase("ё")) {
        phonemStringList.set(0, "о");
        phonemStringList.add(0, "й");
      }
      if (phonemStringList.get(0).equalsIgnoreCase("ю")) {
        phonemStringList.set(0, "у");
        phonemStringList.add(0, "й");
      }
      if (phonemStringList.get(0).equalsIgnoreCase("я")) {
        phonemStringList.set(0, "а");
        phonemStringList.add(0, "й");
      }

        for (int i = 1; i < phonemStringList.size(); i++) {
            String test = phonemStringList.get(i-1);
            String letter = phonemStringList.get(i);

            if (letter.equalsIgnoreCase("e") && test.equals("ь") ) {
              phonemStringList.set(i-1, "й");
              phonemStringList.set(i, "э");
            }
            if (letter.equalsIgnoreCase("ё") && test.equals("ь") ) {
              phonemStringList.set(i-1, "й");
              phonemStringList.set(i, "о");
            }
            if (letter.equalsIgnoreCase("ю") && test.equals("ь") ) {
              phonemStringList.set(i-1, "й");
              phonemStringList.set(i, "у");
            }
            if (letter.equalsIgnoreCase("я") && test.equals("ь") ) {
              phonemStringList.set(i-1, "й");
              phonemStringList.set(i, "а");
            }

            if (letter.equalsIgnoreCase("е") && test.equals("ъ") ) {
              phonemStringList.set(i-1, "й");
              phonemStringList.set(i, "э");
            }
            if (letter.equalsIgnoreCase("ё") && test.equals("ъ") ) {
              phonemStringList.set(i-1, "й");
              phonemStringList.set(i, "о");
            }
            if (letter.equalsIgnoreCase("ю") && test.equals("ъ") ) {
              phonemStringList.set(i-1, "й");
              phonemStringList.set(i, "у");
            }
            if (letter.equalsIgnoreCase("я") && test.equals("ъ") ) {
              phonemStringList.set(i-1, "й");
              phonemStringList.set(i, "а");
            }

            if (letter.equalsIgnoreCase("e") && test.equals(" ") ) {
              phonemStringList.set(i, "э");
              phonemStringList.add(i, "й");
            }
            if (letter.equalsIgnoreCase("ё") && test.equals(" ") ) {
              phonemStringList.set(i, "о");
              phonemStringList.add(i, "й");
            }
            if (letter.equalsIgnoreCase("ю") && test.equals(" ") ) {
              phonemStringList.set(i, "у");
              phonemStringList.add(i, "й");
            }
            if (letter.equalsIgnoreCase("я") && test.equals(" ") ) {
              phonemStringList.set(i, "а");
              phonemStringList.add(i, "й");
            }

            if (letter.equalsIgnoreCase("e") && vowels.contains(test)) {
              phonemStringList.set(i, "э");
              phonemStringList.add(i, "й");
            }
            if (letter.equalsIgnoreCase("ё") && vowels.contains(test)) {
              phonemStringList.set(i, "о");
              phonemStringList.add(i, "й");
            }
            if (letter.equalsIgnoreCase("ю") && vowels.contains(test)) {
              phonemStringList.set(i, "у");
              phonemStringList.add(i, "й");
            }
            if (letter.equalsIgnoreCase("я") && vowels.contains(test)) {
              phonemStringList.set(i, "а");
              phonemStringList.add(i, "й");
            }

          if ( (letter.equals(" ") || i == phonemStringList.size() - 1) && voiceToDeafConsonants.containsKey(test)) {
            phonemStringList.set(i - 1, voiceToDeafConsonants.get(test));
          }
          
          if (letter.equals("й") && consolantList.indexOf(test)!= -1) {
                phonemStringList.set(i-1, test + "'");
                phonemStringList.remove(i);
            }
            if (letter.equals("й") && unpairedHardConsolant.indexOf(test)!= -1) {
                phonemStringList.remove(i);
            }
            if (letter.equalsIgnoreCase("и") && consolantList.indexOf(test)!= -1) {
                phonemStringList.set(i-1, test + "'");
            }
            if (letter.equalsIgnoreCase("и") && unpairedHardConsolant.indexOf(test)!= -1) {
                phonemStringList.set(i, "ы");
            }
            if (letter.equals("й") && test.equals("ъ")) {
                phonemStringList.remove(i-1);
            }
            if (deafToVoiceConsonants.containsKey(letter) && voiceToDeafConsonants.containsKey(test)) {
                phonemStringList.set(i - 1, voiceToDeafConsonants.get(test));
            }
            if (deafToVoiceConsonants.containsKey(letter) && test.equals(" ") &&
                i-2 >= 0 && voiceToDeafConsonants.containsKey(phonemStringList.get(i-2))) {
                phonemStringList.set(i - 1, voiceToDeafConsonants.get(test));
            }
        }

      for (int i = 1; i < phonemStringList.size(); i++) {
        String test = phonemStringList.get(i - 1);
        String letter = phonemStringList.get(i);
        if (letter.equals("ь") && consolantList.contains(test)) {
          phonemStringList.set(i - 1, test + "'");
          phonemStringList.remove(i);
        }
        if (letter.equals("ь") && unpairedHardConsolant.contains(test)) {
          phonemStringList.remove(i);
        }
        if (letter.equalsIgnoreCase("е") && consolantList.contains(test)) {
          phonemStringList.set(i - 1, test + "'");
          phonemStringList.set(i, "э");
        }
        if (letter.equalsIgnoreCase("ё") && consolantList.contains(test)) {
          phonemStringList.set(i - 1, test + "'");
          phonemStringList.set(i, "о");
        }
        if (letter.equalsIgnoreCase("ю") && consolantList.contains(test)) {
          phonemStringList.set(i - 1, test + "'");
          phonemStringList.set(i, "у");
        }
        if (letter.equalsIgnoreCase("я") && consolantList.contains(test)) {
          phonemStringList.set(i - 1, test + "'");
          phonemStringList.set(i, "а");
        }

      }

        System.out.println("Транскрипция:\n"+phonemStringList);

        for (String phonem : phonemStringList) {
            String sound = soundsMap.get(phonem);
            soundsList.add(sound);
        }

        AudioInputStream audioInputStream = null;
        List<AudioInputStream> audioInputStreamList = null;
        AudioFormat audioFormat = null;
        Long frameLength = null;
        File out = new File("B:\\out.wav");

        try {
            // loop through our files first and load them up
            for (String sourceFile : soundsList) {
                audioInputStream = AudioSystem.getAudioInputStream(new File(sourceFile));

                // get the format of first file
                if (audioFormat == null) {
                    audioFormat = audioInputStream.getFormat();
                }

                // add it to our stream list
                if (audioInputStreamList == null) {
                    audioInputStreamList = new ArrayList<>();
                }
                audioInputStreamList.add(audioInputStream);

                // keep calculating frame length
                if(frameLength == null) {
                    frameLength = audioInputStream.getFrameLength();
                }
                else {
                    frameLength += audioInputStream.getFrameLength();
                }

                listLengths.add(((audioInputStream.getFrameLength()+0.0)/audioFormat.getFrameRate()));
            }

            //assert audioFormat != null;
            double duration = (frameLength+0.0)/audioFormat.getFrameRate();

            //System.out.println("duration in seconds: " + duration);

            AudioInputStream appendedFiles = new AudioInputStream(
                    new SequenceInputStream(
                            Collections.enumeration(audioInputStreamList)), audioFormat, frameLength);

            //AudioSystem.write(appendedFiles, AudioFileFormat.Type.WAVE, out);

            Clip clip = AudioSystem.getClip();
            clip.open(appendedFiles);
            clip.start();
            new ReadList().run();
            scanner.nextLine();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (audioInputStream != null) {
                audioInputStream.close();
            }
            if (audioInputStreamList != null) {
                audioInputStreamList = null;
            }
        }
    }
}
