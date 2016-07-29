package com.andre3.bricksalign;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class BricksAlign extends Game {
	SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();

		this.setScreen(new BricksMenuScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}

	public void dispose() {
	}
}
