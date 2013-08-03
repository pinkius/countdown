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

package com.webstersmalley.countdown.webapp;

import com.webstersmalley.countdown.numbers.NumbersBean;
import com.webstersmalley.countdown.numbers.NumbersSolver;
import com.webstersmalley.countdown.words.WordCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CountdownController {
    @Autowired
    private WordCounter wc;

    @RequestMapping("/home")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("home");
        return mav;
    }

    @RequestMapping("/populate")
    public ModelAndView populate() {
        wc.parseResource("/2+2lemma.txt");
//        wc.parseResource("/mobydick.txt");
//        wc.parseResource("/theprince.txt");
//        wc.parseResource("/waroftheworlds.txt");
//        wc.parseResource("/pride.txt");
//        wc.parseResource("/secondvariety.txt");
//        wc.parseResource("/sherlock.txt");
        wc.saveToDatabase();

        ModelAndView mav = new ModelAndView("redirect:home.html");
        return mav;
    }

    @RequestMapping(value = "/solveLetters")
    public ModelAndView solveLetters(@RequestParam String letters) {
        ModelAndView mav = new ModelAndView("showLettersSolutions");
        if (letters != null) {
            mav.addObject("matches", wc.getMatches(letters.toUpperCase()));
        }
        return mav;
    }

    @RequestMapping(value = "/solveNumbers")
    public ModelAndView solveNumbers(@RequestParam String numbers) {
        ModelAndView mav = new ModelAndView("showNumbersSolutions");

        if (numbers != null) {
            NumbersBean bean = new NumbersBean(numbers);
            NumbersSolver solver = new NumbersSolver();
            mav.addObject("solutions", solver.solve(bean, 1));
        }
        return mav;
    }

}
