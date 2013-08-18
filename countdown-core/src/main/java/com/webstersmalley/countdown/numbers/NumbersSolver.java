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

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("numbersSolver")
public class NumbersSolver {
    private Logger logger = Logger.getLogger(getClass());

    public List<NumbersSolution> solve(NumbersBean bean, int threshold) {
        long startTime = System.currentTimeMillis();
        List<NumbersSolution> solutionResults = new ArrayList<NumbersSolution>();

        Set<NumbersSolution> solutionResultsSet = new HashSet<NumbersSolution>();

        Permute p = new Permute();
        List<List<Integer>> permutations = p.getPermutations(bean.getNumbers());

        for (List<Integer> permutation : permutations) {
            Set<Node> solutionNodes = getNodes(permutation);

            for (Node node : solutionNodes) {
                try {
                    if (Math.abs(node.getValue() - bean.getTarget()) <= threshold) {
                        NumbersSolution solution = new NumbersSolution();
                        solution.setTopNode(node);
                        solution.setTarget(bean.getTarget());

                        solutionResultsSet.add(solution);
                    }
                } catch (Exception e) {
                }
            }
        }

        solutionResults.addAll(solutionResultsSet);

        Collections.sort(solutionResults);

        long endTime = System.currentTimeMillis();
        logger.info("Solved (" + bean + ") in: " + (endTime - startTime) + "ms");

        return solutionResults;
    }

    private Node combineNodes(Node n1, Node n2, Operator o) {
        CalculationNode c = new CalculationNode(n1, n2, o);
        if (c.givesIntegerResult()) {
            return c;
        } else {
            return null;
        }
    }

    private Node getNode(Node n1, Node n2, Operator o) {
        switch (o) {
            case IGNORE_LEFT:
                return n2;
            case IGNORE_RIGHT:
                return n1;
            case TIMES:
                if (n1.getValue() == 1) {
                    return n2;
                } else if (n2.getValue() == 1) {
                    return n1;
                } else {
                    return combineNodes(n1, n2, o);
                }
            case DIVIDE:
                if (n2.getValue() == 1) {
                    return n1;
                } else {
                    return combineNodes(n1, n2, o);
                }
            default:
                return combineNodes(n1, n2, o);
        }
    }

    protected Set<Node> getNodes(List<Integer> permutation) {
        Set<Node> results = new HashSet<Node>();
        Node n1 = new IntegerNode(permutation.get(0));
        if (permutation.size() == 1) {
            results.add(n1);
        } else {
            List<Integer> backPerm = new ArrayList<Integer>();
            backPerm.addAll(permutation);
            backPerm.remove(0);
            Set<Node> backNodes = getNodes(backPerm);
            for (Node n2 : backNodes) {
                for (Operator o : Operator.values()) {
                    Node n = getNode(n1, n2, o);
                    if (n != null) {
                        results.add(n);
                    }
                }
            }
        }
        return results;

    }

}
