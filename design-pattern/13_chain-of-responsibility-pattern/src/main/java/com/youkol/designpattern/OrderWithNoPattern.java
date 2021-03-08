package com.youkol.designpattern;

public class OrderWithNoPattern {

    public Message interrupt1() {
        return new Message();
    }

    public Message interrupt2() {
        return new Message();
    }

    public Message interrupt3() {
        return new Message();
    }

    public Message interrupt4() {
        return new Message();
    }

    public Message interrupt5() {
        return new Message();
    }

    public Message interrupt6() {
        throw new RuntimeException();
    }

    public Message interrupt7() {
        throw new RuntimeException();
    }

    public static void order1() {
        OrderWithNoPattern order = new OrderWithNoPattern();
        if (order.interrupt1().getResult() == 1) {
            if (order.interrupt2().getResult() == 1) {
                if (order.interrupt3().getResult() == 1) {
                    if (order.interrupt4().getResult() == 1) {
                        if (order.interrupt5().getResult() == 1) {
                            System.out.println("success...");
                        }
                    }
                }
            }
        }
    }

    public static void order2() {
        OrderWithNoPattern order = new OrderWithNoPattern();
        try {
            order.interrupt1();
            order.interrupt2();
            order.interrupt3();
            order.interrupt6();
            order.interrupt7();
        } catch (RuntimeException ex) {
            System.out.println("fail...");
        }
    }

    public static void main(String[] args) {
        System.out.println("======Run order1 example...");
        OrderWithNoPattern.order1();
        System.out.println("======Run order2 example...");
        OrderWithNoPattern.order2();
        System.out.println("======Run Order end...");
    }

    public static class Message {
        private int result;
        private String message;

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }
}
