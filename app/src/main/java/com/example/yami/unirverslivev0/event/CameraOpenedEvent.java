package com.example.yami.unirverslivev0.event;

/**
 * Created by Yami on 8/1/2015.
 */


import android.hardware.Camera;

/**
 * Used to pass the parameters of the opened camera to subscribers.
 */
public class CameraOpenedEvent {

    public Camera.Parameters params;

    public CameraOpenedEvent(Camera.Parameters params) {
        this.params = params;
    }

}
