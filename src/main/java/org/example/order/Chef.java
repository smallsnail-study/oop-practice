package org.example.order;

// 요리사
public class Chef {
    public Cook makeCook(MenuItem menuItem) {
        return new Cook("돈까스", 5000);
    }
}
