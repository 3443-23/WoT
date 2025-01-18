package ru.ee.shesternin.ru.ma.tiabut.battletanks

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_DPAD_DOWN
import android.view.KeyEvent.KEYCODE_DPAD_LEFT
import android.view.KeyEvent.KEYCODE_DPAD_RIGHT
import android.view.KeyEvent.KEYCODE_DPAD_UP
import android.widget.FrameLayout
import  ru.ee.shesternin.ru.ma.tiabut.battletanks.Direction.UP
import  ru.ee.shesternin.ru.ma.tiabut.battletanks.Direction.DOWN
import  ru.ee.shesternin.ru.ma.tiabut.battletanks.Direction.LEFT
import  ru.ee.shesternin.ru.ma.tiabut.battletanks.Direction.RIGHT
import ru.ee.shesternin.ru.ma.tiabut.battletanks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean{
        when (keyCode) {
            KEYCODE_DPAD_UP -> move(UP)
            KEYCODE_DPAD_DOWN -> move(DOWN)
            KEYCODE_DPAD_LEFT -> move(LEFT)
            KEYCODE_DPAD_RIGHT -> move(RIGHT)
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun move (direction: Direction) {
        when (direction) {
            UP -> {
                binding.myTank.rotation = 0f
                (binding.myTank.layoutParams as FrameLayout.LayoutParams).topMargin += -50
            }

            DOWN -> {
                binding.myTank.rotation = 180f
                (binding.myTank.layoutParams as FrameLayout.LayoutParams).topMargin += 50
            }

            LEFT -> {
                binding.myTank.rotation = 270f
                (binding.myTank.layoutParams as FrameLayout.LayoutParams).leftMargin -= 50
            }

            RIGHT -> {
                binding.myTank.rotation = 90f
                (binding.myTank.layoutParams as FrameLayout.LayoutParams).leftMargin += 50
            }
        }
        binding.container.removeView(binding.myTank)
        binding.container.addView(binding.myTank)
    }
}