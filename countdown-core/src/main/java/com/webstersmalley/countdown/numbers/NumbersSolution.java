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

public class NumbersSolution implements Comparable {
    @Override
    public int compareTo(Object o) {
        NumbersSolution n = (NumbersSolution) o;
        if (this.getCloseness() == 0 && n.getCloseness() == 0) {
            return (getComplexity() - n.getComplexity());
        } else {
            return 1000 * (n.getCloseness() - getCloseness());
        }
    }

    public int getCloseness() {
        return -Math.abs(target - topNode.getValue());
    }

    public int getComplexity() {
        return topNode.getComplexity();
    }

    private Node topNode;

    private int target;


    public String toString() {
        StringBuffer sb = new StringBuffer();
        int difference = target - topNode.getValue();
        if (difference >= 0) {
            sb.append("+");
        } else {
            sb.append("-");
        }
        sb.append(difference);
        sb.append(": ");
        sb.append(topNode);
        sb.append(" = ");
        sb.append(topNode.getValue());
        return sb.toString();
    }

    public Node getTopNode() {
        return topNode;
    }

    public void setTopNode(Node topNode) {
        this.topNode = topNode;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NumbersSolution) {
            NumbersSolution n = (NumbersSolution) obj;
            return (this.getTarget() == n.getTarget() && this.getTopNode().equals(n.getTopNode()));
        }
        return false;
    }

    @Override
    public int hashCode() {
        return target + 31 * topNode.hashCode();
    }


}
