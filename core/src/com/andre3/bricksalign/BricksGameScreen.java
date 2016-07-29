package com.andre3.bricksalign;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

import javax.sound.midi.SysexMessage;

/**
 * Created by ODBBROW on 7/29/2016.
 */
public class BricksGameScreen implements Screen {

    BricksAlign game;
    OrthographicCamera camera;
    ShapeRenderer shape;
    Array<ShapeRenderer> shapes;

    public BricksGameScreen(BricksAlign game) {
        this.game = game;

        shape = new ShapeRenderer();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 400, 480);
    }

    @Override
    public void render(float delta) {
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        System.out.println("Constant move?");
        shape.setColor(Color.YELLOW);
        shape.begin(ShapeRenderer.ShapeType.Filled);

         float x = MathUtils.random(0, 800-64);


        shape.rect(100, x, 100, 100);
        shape.end();
    }

    public void spawnShape()
    {



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
