package com.johnny.store.dto;

public class OrderHistoryResponse<T> extends UnifiedResponse<T> {
    private int toPayOrderCount;
    private int toReceiveOrderCount;
    private int toReviewOrderCount;

    public int getToPayOrderCount() {
        return toPayOrderCount;
    }

    public void setToPayOrderCount(int toPayOrderCount) {
        this.toPayOrderCount = toPayOrderCount;
    }

    public int getToReceiveOrderCount() {
        return toReceiveOrderCount;
    }

    public void setToReceiveOrderCount(int toReceiveOrderCount) {
        this.toReceiveOrderCount = toReceiveOrderCount;
    }

    public int getToReviewOrderCount() {
        return toReviewOrderCount;
    }

    public void setToReviewOrderCount(int toReviewOrderCount) {
        this.toReviewOrderCount = toReviewOrderCount;
    }
}
