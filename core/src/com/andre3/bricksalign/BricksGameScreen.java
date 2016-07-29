package com.andre3.bricksalign;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Iterator;

import javax.sound.midi.SysexMessage;

/**
 * Created by ODBBROW on 7/29/2016.
 */
public class BricksGameScreen implements Screen {

    BricksAlign game;
    OrthographicCamera camera;
    ShapeRenderer shape;
    Array<Rectangle> shapes;
    float lastDropTime;

    public BricksGameScreen(BricksAlign game) {
        this.game = game;

        shape = new ShapeRenderer();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 400, 480);

        shapes = new Array<Rectangle>();
        spawnShape();

    }

    @Override
    public void render(float delta) {
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        System.out.println("Constant move?");
        shape.setColor(Color.YELLOW);
        shape.begin(ShapeRenderer.ShapeType.Filled);

         float x = MathUtils.random(0, 800-64);
        for(Rectangle square : shapes) {

            shape.rect(square.x, square.y, square.width, square.height);
        }
        shape.end();

        if(TimeUtils.nanoTime() - lastDropTime > 1000000000) spawnShape();

        Iterator<Rectangle> iter = shapes.iterator();
        while(iter.hasNext()) {
            Rectangle shape = iter.next();
            shape.y -= 200 * Gdx.graphics.getDeltaTime();
            if(shape.y + 64 < 0) iter.remove();

        }

    }

    public void spawnShape()
    {
        Rectangle square = new Rectangle();
        square.x = MathUtils.random(0, 800-64);
        square.y = 480;
        square.width = 100;
        square.height = 100;
        shapes.add(square);
        lastDropTime = TimeUtils.nanoTime();
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
