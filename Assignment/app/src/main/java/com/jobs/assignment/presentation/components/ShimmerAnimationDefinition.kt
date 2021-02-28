package com.jobs.assignment.presentation.components

import androidx.compose.animation.core.*

class ShimmerAnimationDefinitions(
    private val widthPx: Float,
    private val heightPx: Float,
) {
    var gradientWidth: Float

    init {
        gradientWidth = 0.2f * heightPx
    }

    enum class AnimationState {
        START, END
    }

    val xShimmerPropKey = FloatPropKey("xShimmer")
    val yShimmerPropKey = FloatPropKey("yShimmer")

    val shimmerTransitionDefinition = transitionDefinition<AnimationState> {
        state(AnimationState.START) {
            this[xShimmerPropKey] = 0f
            this[yShimmerPropKey] = 0f
        }
        state(AnimationState.END) {
            this[xShimmerPropKey] = widthPx + gradientWidth
            this[yShimmerPropKey] = heightPx + gradientWidth
        }
        transition(AnimationState.START, AnimationState.END) {
            xShimmerPropKey using infiniteRepeatable(
                animation = tween(
                    durationMillis = 1300,
                    delayMillis = 300,
                    easing = LinearEasing
                ),
            )
            yShimmerPropKey using infiniteRepeatable(
                animation = tween(
                    durationMillis = 1300,
                    delayMillis = 300,
                    easing = LinearEasing
                ),
            )
        }
    }
}