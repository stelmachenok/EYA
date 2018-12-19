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


        consolantList.add("л");
        consolantList.add("м");
        consolantList.add("н");
        consolantList.add("р");
        consolantList.add("п");
        consolantList.add("к");
        consolantList.add("т");
        consolantList.add("в");
        consolantList.add("з");
        consolantList.add("ж");
        consolantList.add("б");
        consolantList.add("д");
        consolantList.add("г");
        consolantList.add("ф");
        consolantList.add("с");
        consolantList.add("ш");
        consolantList.add("щ");
        consolantList.add("х");
        consolantList.add("ч");

        String wavFile1 = "src/sounds_max/wav1.wav"; // а
        String wavFile2 = "src/sounds_max/wav2.wav"; // б
        String wavFile3 = "src/sounds_max/wav3.wav"; // в
        String wavFile4 = "src/sounds_max/wav4.wav"; // г
        String wavFile5 = "src/sounds_max/wav5.wav"; // д
        //String wavFile6 = "src/sounds_max/wav6.wav"; // е
        String wavFile7 = "src/sounds_max/wav7.wav"; // ж
        String wavFile8 = "src/sounds_max/wav8.wav"; // з
        String wavFile9 = "src/sounds_max/wav9.wav"; // и
        String wavFile10 = "src/sounds_max/wav10.wav"; // к
        String wavFile11 = "src/sounds_max/wav11.wav"; // л
        String wavFile12 = "src/sounds_max/wav12.wav"; // м
        String wavFile13 = "src/sounds_max/wav13.wav"; // н
        String wavFile14 = "src/sounds_max/wav14.wav"; // о
        String wavFile15 = "src/sounds_max/wav15.wav"; // п
        String wavFile16 = "src/sounds_max/wav16.wav"; // р
        String wavFile17 = "src/sounds_max/wav17.wav"; // с
        String wavFile18 = "src/sounds_max/wav18.wav"; // т
        String wavFile19 = "src/sounds_max/wav19.wav"; // у
        String wavFile20 = "src/sounds_max/wav20.wav"; // ф
        String wavFile21 = "src/sounds_max/wav21.wav"; // х
        String wavFile22 = "src/sounds_max/wav22.wav"; // ц
        String wavFile23 = "src/sounds_max/wav23.wav"; // ч
        String wavFile24 = "src/sounds_max/wav24.wav"; // щ
        String wavFile25 = "src/sounds_max/wav25.wav"; // ш
        String wavFile26 = "src/sounds_max/wav26.wav"; // э
        //String wavFile27 = "src/sounds_max/wav27.wav"; // ю
        //String wavFile28 = "src/sounds_max/wav28.wav"; // я
        String wavFile29 = "src/sounds_max/wav29.wav"; // ы
        String wavFile30 = "src/sounds_max/wav30.wav"; // "space"
        String wavFile31 = "src/sounds_max/wav31.wav"; // с
        String wavFile32 = "src/sounds_max/wav32.wav"; // т
        String wavFile33 = "src/sounds_max/wav33.wav"; // у
        String wavFile34 = "src/sounds_max/wav34.wav"; // ф
        String wavFile35 = "src/sounds_max/wav35.wav"; // х
        String wavFile36 = "src/sounds_max/wav36.wav"; // ц
        String wavFile37 = "src/sounds_max/wav37.wav"; // ч
        String wavFile38 = "src/sounds_max/wav38.wav"; // щ
        String wavFile39 = "src/sounds_max/wav39.wav"; // ш
        String wavFile40 = "src/sounds_max/wav40.wav"; // э
        String wavFile41 = "src/sounds_max/wav41.wav"; // с
        String wavFile42 = "src/sounds_max/wav42.wav"; // т
        String wavFile43 = "src/sounds_max/wav43.wav"; // у
        String wavFile44 = "src/sounds_max/wav44.wav"; // ф
        String wavFile45 = "src/sounds_max/wav45.wav"; // х
        String wavFile46 = "src/sounds_max/wav46.wav"; // ц
        String wavFile47 = "src/sounds_max/wav47.wav"; // ч
        String wavFile48 = "src/sounds_max/wav48.wav"; // щ



        soundsMap.put("а", "src/sounds_max/а2.wav");
        soundsMap.put("б", "src/sounds_max/б.wav");
        soundsMap.put("в", "src/sounds_max/в.wav");
        soundsMap.put("г", "src/sounds_max/г.wav");
        soundsMap.put("д", "src/sounds_max/д.wav");
        //soundsMap.put("е", wavFile6);
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
        //soundsMap.put("ю", wavFile27);
        //soundsMap.put("я", wavFile28);
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

        System.out.println("Введите текст:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String phoneticString = input
                .replaceAll("я","йа")
                .replaceAll("е", "йэ")
                .replaceAll("ю","йу")
                .replaceAll("ё", "йо")
                .replaceAll(",", " ");





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

        for (int i = 1; i < phonemStringList.size(); i++) {
            String test = phonemStringList.get(i-1);
            String letter = phonemStringList.get(i);
            if (letter.equals("й") && consolantList.indexOf(test)!= -1) {
                phonemStringList.set(i-1, test + "'");
                phonemStringList.remove(i);
            }
            if (letter.equals("и") && consolantList.indexOf(test)!= -1) {
                phonemStringList.set(i-1, test + "'");
            }
            if (letter.equals("й") && phonemStringList.get(i-1).equals("ъ")) {
                phonemStringList.remove(i-1);
            }
            if (letter.equals("ь")) {
                phonemStringList.set(i-1, test + "'");
                phonemStringList.remove(i);
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
