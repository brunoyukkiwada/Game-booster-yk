class FPSMonitor {

    private var frames = 0
    private var lastTime = System.nanoTime()

    fun start() {

        Choreographer.getInstance().postFrameCallback(object :
            Choreographer.FrameCallback {

            override fun doFrame(frameTimeNanos: Long) {

                frames++

                if(frameTimeNanos - lastTime >= 1_000_000_000){

                    println("FPS: $frames")

                    frames = 0
                    lastTime = frameTimeNanos
                }

                Choreographer.getInstance().postFrameCallback(this)
            }
        })
    }
}
