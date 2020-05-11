package com.example.duokan.base;

public class DkShelfViewConfig {
    final public int prefetchCount;

    final public int cacheSize;

    final public int column;

    private DkShelfViewConfig(Builder builder) {
        prefetchCount = builder.mPrefetchCount;
        cacheSize = builder.mCacheSize;
        column = builder.mColumn;
    }

    public static class Builder {
        int mColumn = 1;
        int mPrefetchCount = 0;
        int mCacheSize = 0;

        public Builder prefetchCount(final int count) {
            mPrefetchCount = count;
            return this;
        }

        public Builder cacheSize(final int cacheSize) {
            mCacheSize = cacheSize;
            return this;
        }

        public Builder column(final int column) {
            mColumn = column;
            return this;
        }

        public DkShelfViewConfig build() {
            return new DkShelfViewConfig(this);
        }

    }
}
