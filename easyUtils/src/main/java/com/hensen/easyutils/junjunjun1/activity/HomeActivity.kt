package com.hensen.easyutils.junjunjun1.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hensen.easyutils.R

abstract class HomeActivity : AppCompatActivity() {

    private val fragment1: Fragment = getFragment()[0]
    private val fragment2: Fragment = getFragment()[1]
    private val fragment3: Fragment = getFragment()[2]

    abstract fun getFragment(): List<Fragment>
    abstract fun getIcon(): List<Int>
    abstract fun getTitlee(): List<String>

    private var viewPager: ViewPager? = null
    private var navigation: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewPager = findViewById(R.id.viewpager)
        viewPager?.offscreenPageLimit = 3
        viewPager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int, positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                navigation?.getMenu()?.getItem(position)?.setChecked(true)
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })

        navigation = findViewById(R.id.navigation)

        navigation?.menu?.findItem(R.id.navigation_item1)?.setIcon(getIcon()[0])
        navigation?.menu?.findItem(R.id.navigation_item2)?.setIcon(getIcon()[1])
        navigation?.menu?.findItem(R.id.navigation_item3)?.setIcon(getIcon()[2])
        navigation?.menu?.findItem(R.id.navigation_item1)?.setTitle(getTitlee()[0])
        navigation?.menu?.findItem(R.id.navigation_item2)?.setTitle(getTitlee()[1])
        navigation?.menu?.findItem(R.id.navigation_item3)?.setTitle(getTitlee()[2])

        navigation?.setOnNavigationItemSelectedListener { item ->
            viewPager?.setCurrentItem(item.getOrder())
            true
        }

        viewPager?.setAdapter(object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {
                when (position) {
                    0 -> return fragment1
                    1 -> return fragment2
                    2 -> return fragment3
                }
                return fragment1
            }

            override fun getCount(): Int {
                return 3
            }
        })
    }

    fun jumpItem(position: Int) {
        viewPager?.setCurrentItem(position)
    }
}