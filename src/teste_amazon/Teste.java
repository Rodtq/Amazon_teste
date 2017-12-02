
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste_amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author rodtq
 */
public class Teste {

    private final List<String> targetTags = new ArrayList<>();
    private final List<String> availableTags = new ArrayList<>();

    public void run() {
        targetTags.add("bila");
        targetTags.add("bola");
        targetTags.add("gaga");
        availableTags.add("pipa");
        availableTags.add("bila");
        availableTags.add("cola");
        availableTags.add("pipa");
        availableTags.add("tota");
        availableTags.add("bola");
        availableTags.add("bala");
        availableTags.add("gaga");
        availableTags.add("pipa");
        availableTags.add("bula");
        availableTags.add("bola");
        availableTags.add("pipa");
        availableTags.add("gaga");
        availableTags.add("bila");
        availableTags.add("bola");
        availableTags.add("bela");
        availableTags.add("tota");
        availableTags.add("cola");
        availableTags.add("pipa");

        System.out.println("##############");
        System.out.println("#Teste Amazon#");
        System.out.println("##############");
        System.out.println("");
        arrayRangeChecker();

    }

    private void arrayRangeChecker() {
        List<TestModel> modelList = new ArrayList<>();
        for (int i = 0; i < availableTags.size(); i++) {
            TestModel model = new TestModel();
            model.setAttempt(i);
            String firstItem = availableTags.get(i);
            boolean isOk;
            //first index
            isOk = targetTags.stream().anyMatch(m -> m.equals(firstItem));
            if (isOk) {
                model.setFirstIndex(i);
                model.setFirstWord(firstItem);
                //go for second index
                for (int j = i + 1; j < availableTags.size(); j++) {
                    String secondItem = availableTags.get(j);
                    if (targetTags.stream().anyMatch(m -> m.equals(secondItem))) {

                        model.setSecondIndex(j);
                        model.setSecondWord(secondItem);

                        for (int k = j + 1; k < availableTags.size(); k++) {
                            String thirdItem = availableTags.get(k);
                            if (targetTags.stream().anyMatch(m -> m.equals(thirdItem))) {
                                model.setThirdIndex(k);
                                model.setThirdWord(thirdItem);
                                modelList.add(model);
                                break;
                            }
                        }
                        break;
                    }
                }

                System.out.println("##Attempt : " + model.getAttempt());
                System.out.println("first Index: " + model.getFirstIndex() + ", word :" + model.getFirstWord());
                System.out.println("second Index: " + model.getSecondIndex() + ", word :" + model.getSecondWord());
                System.out.println("third Index: " + model.getThirdIndex() + ", word :" + model.getThirdWord());

                model.setCalcRange(model.getThirdIndex() - model.getFirstIndex());
                System.out.println("range: " + model.getCalcRange());
                System.out.println("");
                System.out.println("");
            } else {
                System.out.println("Attempt: " + i + " doesn't find a applicable value");
            }
        }
        System.out.println("");
        System.out.println("##The Correct Answer is : ");
        TestModel winner = modelList.stream().filter(m -> m.getCalcRange() > 0).min(Comparator.comparing(TestModel::getCalcRange)).get();
        System.out.println("##Attempt : " + winner.getAttempt());
        System.out.println("first Index: " + winner.getFirstIndex() + ", word :" + winner.getFirstWord());
        System.out.println("second Index: " + winner.getSecondIndex() + ", word :" + winner.getSecondWord());
        System.out.println("third Index: " + winner.getThirdIndex() + ", word :" + winner.getThirdWord());

        winner.setCalcRange(winner.getThirdIndex() - winner.getFirstIndex());
        System.out.println("range: " + winner.getCalcRange());
        System.out.println("");
        System.out.println("");

    }

}
