// Corbin Park
// 3/8/2020
// Prefix notation expression evaluator 
// "---- 8 1 1 1 1"


class Prefix {
    public Result prefix(String exp, int start, int stop) {
        Result r1 = new Result();
        Result r2 = new Result();
        Result returned = new Result();
        if (exp.charAt(start) < 48 && exp.charAt(start + 1) == 32) {
                r1 = prefix(exp, start + 2, stop);
                r2 = prefix(exp, r1.index + 1, stop);
                char c = exp.charAt(start);
                switch (c) {
                    case '+':
                        returned.value = r1.value + r2.value;
                        returned.index = r2.index;
                        break;
                    case '-':
                        returned.value = r1.value - r2.value;
                        returned.index = r2.index;
                        break;
                    case '*':
                        returned.value = r1.value * r2.value;
                        returned.index = r2.index;
                        break;
                    case '/':
                        returned.value = r1.value / r2.value;
                        returned.index = r2.index;
                        break;
                    default:
                }
                return returned;
            }
            else {
                returned.index = start;
                while (returned.index != stop && exp.charAt(returned.index) != 32) {
                    returned.index++;
                }
                returned.value = Double.valueOf(exp.substring(start, returned.index + 1));
                return returned;
            }

    }

public static void main (String[] args) {
        String exp = "* + - 33 4 2 + 1 2";
        Result answer = new Result();
        Prefix p = new Prefix();
        answer = p.prefix(exp, 0, 17);
        System.out.println("Result: " + answer.value + "    Index: " + answer.index);
    }
}


class Result {
    Double value;
    int index;
}