package com.example.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

private val Dark = Color(0xff151515)
private val White = Color(0xffF2F2F3)
private val Green = Color(0xff12B956)
private val DarkGray = Color(0xff24252A)
private val LightGray = Color(0xff32333A)
private val Stroke = Color(0xff4D555E)
private val Glass = Color(0xff32333A)
private val Caption = Color(0xffF2F2F3)

@Immutable
data class ColorPalette(
    val dark: Color,
    val white: Color,
    val green: Color,
    val darkGray: Color,
    val lightGray: Color,
    val stroke: Color,
    val glass: Color,
    val caption: Color,
)

val BasePalette = ColorPalette(
    dark = Dark,
    white = White,
    green = Green,
    darkGray = DarkGray,
    lightGray = LightGray,
    stroke = Stroke,
    glass = Glass,
    caption = Caption,
)

val LocalColors = staticCompositionLocalOf {
    BasePalette
}