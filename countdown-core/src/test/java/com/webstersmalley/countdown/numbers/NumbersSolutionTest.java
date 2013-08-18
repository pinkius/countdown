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

package com.webstersmalley.countdown.numbers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumbersSolutionTest {
    @Test
    public void numbersSolutionTest() {
        NumbersSolution solution = new NumbersSolution();
        solution.setTarget(100);
        solution.setTopNode(new CalculationNode(new IntegerNode(9), new IntegerNode(100), Operator.PLUS));
        assertEquals(109, solution.getTopNode().getValue());
    }

}
