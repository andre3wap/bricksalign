package com.andre3.bricksalign;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Created by ODBBROW on 7/29/2016.
 */
public class BricksGameScreen implements Screen {

    BricksAlign game;
    OrthographicCamera camera;

    public BricksGameScreen(BricksAlign game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 400, 480);
    }

    @Override
    public void render(float delta) {
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);


    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
