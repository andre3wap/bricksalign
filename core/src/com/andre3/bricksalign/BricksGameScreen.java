package com.andre3.bricksalign;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
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
    Texture squareimg;
    Rectangle square = new Rectangle();
    float h, w;

    public BricksGameScreen(BricksAlign game) {
        this.game = game;

        h = Gdx.graphics.getHeight();
        w = Gdx.graphics.getWidth();

        squareimg = new Texture(Gdx.files.internal("square.png"));
        shape = new ShapeRenderer();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 480, 800);

        shapes = new Array<Rectangle>();
        spawnShape();

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        shape.setColor(Color.YELLOW);
        shape.begin(ShapeRenderer.ShapeType.Filled);

         float x = MathUtils.random(0, 800-64);
        ///game.batch.begin();

        for(Rectangle square : shapes) {

            /////game.batch.draw(squareimg,square.x, square.y );
            shape.rect(square.x, square.y, square.width, square.height);


            /////System.out.println("Square size" + square.x);

            ////if(square.x < 0) square.x = 0;
            ///if(square.x > 1757 - 64)square.x = 1757 - 64;

            ///// game.batch.end();
            if(Gdx.input.isTouched()) {
                Vector3 touchPos = new Vector3();
                touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
                camera.unproject(touchPos);
                square.x = touchPos.x - 32 / 2;
            }


        }





        shape.end();


        System.out.println(square.y);
        if(square.y < -1)
        {
            System.out.println("Launch new shape" + h);
            spawnShape();
        }

        Iterator<Rectangle> iter = shapes.iterator();
        while(iter.hasNext()) {
            Rectangle shape = iter.next();
            shape.y -= 1;
            if(square.y < -1) iter.remove();

        }

        ////System.out.println(shapes.size);

    }

    public void spawnShape()
    {
        square.x = MathUtils.random(0, 480-64);
        square.y = 1000;
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
