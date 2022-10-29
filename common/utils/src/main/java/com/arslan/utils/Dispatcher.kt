package com.arslan.utils
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val coroutineDispatchers: CoroutineDispatchers)
enum class CoroutineDispatchers {
    IO
}