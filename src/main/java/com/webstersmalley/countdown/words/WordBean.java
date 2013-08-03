/*
 * Copyright 2013 Webster Smalley
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.webstersmalley.countdown.words;

public class WordBean implements Comparable {
    private int countA;
    private int countB;
    private int countC;
    private int countD;
    private int countE;
    private int countF;
    private int countG;
    private int countH;
    private int countI;
    private int countJ;
    private int countK;
    private int countL;
    private int countM;
    private int countN;
    private int countO;
    private int countP;
    private int countQ;
    private int countR;
    private int countS;
    private int countT;
    private int countU;
    private int countV;
    private int countW;
    private int countX;
    private int countY;
    private int countZ;

    private String theWord;
    private int length;

    public WordBean(String theWord) {
        this.theWord = theWord;
        this.length = theWord.length();

        for (char letter : theWord.toCharArray()) {
            switch (letter) {
                case 'A':
                    countA++;
                    break;
                case 'B':
                    countB++;
                    break;
                case 'C':
                    countC++;
                    break;
                case 'D':
                    countD++;
                    break;
                case 'E':
                    countE++;
                    break;
                case 'F':
                    countF++;
                    break;
                case 'G':
                    countG++;
                    break;
                case 'H':
                    countH++;
                    break;
                case 'I':
                    countI++;
                    break;
                case 'J':
                    countJ++;
                    break;
                case 'K':
                    countK++;
                    break;
                case 'L':
                    countL++;
                    break;
                case 'M':
                    countM++;
                    break;
                case 'N':
                    countN++;
                    break;
                case 'O':
                    countO++;
                    break;
                case 'P':
                    countP++;
                    break;
                case 'Q':
                    countQ++;
                    break;
                case 'R':
                    countR++;
                    break;
                case 'S':
                    countS++;
                    break;
                case 'T':
                    countT++;
                    break;
                case 'U':
                    countU++;
                    break;
                case 'V':
                    countV++;
                    break;
                case 'W':
                    countW++;
                    break;
                case 'X':
                    countX++;
                    break;
                case 'Y':
                    countY++;
                    break;
                case 'Z':
                    countZ++;
                    break;
            }
        }
    }

    public String toString() {
        return theWord;
    }

    public int getCountA() {
        return countA;
    }

    public int getCountB() {
        return countB;
    }

    public int getCountC() {
        return countC;
    }

    public int getCountD() {
        return countD;
    }

    public int getCountE() {
        return countE;
    }

    public int getCountF() {
        return countF;
    }

    public int getCountG() {
        return countG;
    }

    public int getCountH() {
        return countH;
    }

    public int getCountI() {
        return countI;
    }

    public int getCountJ() {
        return countJ;
    }

    public int getCountK() {
        return countK;
    }

    public int getCountL() {
        return countL;
    }

    public int getCountM() {
        return countM;
    }

    public int getCountN() {
        return countN;
    }

    public int getCountO() {
        return countO;
    }

    public int getCountP() {
        return countP;
    }

    public int getCountQ() {
        return countQ;
    }

    public int getCountR() {
        return countR;
    }

    public int getCountS() {
        return countS;
    }

    public int getCountT() {
        return countT;
    }

    public int getCountU() {
        return countU;
    }

    public int getCountV() {
        return countV;
    }

    public int getCountW() {
        return countW;
    }

    public int getCountX() {
        return countX;
    }

    public int getCountY() {
        return countY;
    }

    public int getCountZ() {
        return countZ;
    }

    public String getTheWord() {
        return theWord;
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof WordBean) {
            return this.theWord.equals(((WordBean) o).getTheWord());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.theWord.hashCode();
    }

    @Override
    public int compareTo(Object o) {
        WordBean other = (WordBean) o;
        if (other.getLength() == length) {
            return theWord.compareTo(other.getTheWord());
        } else {
            return other.getLength() - length;
        }
    }
}
