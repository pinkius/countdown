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

public enum Operator {
    PLUS("+") {
        double eval(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        double eval(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        double eval(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        double eval(double x, double y) {
            return x / y;
        }
    },
    IGNORE_LEFT("L") {
        double eval(double x, double y) {
            return y;
        }
    },
    IGNORE_RIGHT("R") {
        double eval(double x, double y) {
            return x;
        }
    };

    private final String representation;

    Operator(String representation) {
        this.representation = representation;
    }

    public String toString() {
        return representation;
    }

    abstract double eval(double x, double y);
}
