package com.example.unicare.Utils

import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp


sealed class FontSizeType {
    object Small : FontSizeType()
    object Medium : FontSizeType()
    object Large : FontSizeType()
    object ExtraLarge : FontSizeType()
}

class FontSize {
    companion object {
        fun get(size: FontSizeType): TextUnit {
            return when (size) {
                is FontSizeType.Small -> 12.sp
                is FontSizeType.Medium -> 16.sp
                is FontSizeType.Large -> 20.sp
                is FontSizeType.ExtraLarge -> 24.sp
            }
        }
    }
}