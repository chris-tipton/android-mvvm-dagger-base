package com.tiptop.androidbase.di

import dagger.Subcomponent


@Subcomponent
interface ViewModelSubcomponent {
    @Subcomponent.Builder
    interface Builder {
        fun build(): ViewModelSubcomponent
    }
}