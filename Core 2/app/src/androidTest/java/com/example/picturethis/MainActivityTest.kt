package com.example.picturethis


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val appCompatImageView = onView(
            allOf(
                withId(R.id.one), withContentDescription("choco_cake"),
                childAtPosition(
                    allOf(
                        withId(R.id.linearLayout),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            0
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatImageView.perform(click())

        val viewGroup = onView(
            allOf(
                withId(R.id.secondary),
                withParent(
                    allOf(
                        withId(android.R.id.content),
                        withParent(withId(R.id.decor_content_parent))
                    )
                ),
                isDisplayed()
            )
        )
        viewGroup.check(matches(isDisplayed()))

        val imageView = onView(
            allOf(
                withId(R.id.fImg), withContentDescription("food_img"),
                withParent(
                    allOf(
                        withId(R.id.secondary),
                        withParent(withId(android.R.id.content))
                    )
                ),
                isDisplayed()
            )
        )
        imageView.check(matches(isDisplayed()))

        val editText = onView(
            allOf(
                withId(R.id.f_name), withText("Cake"),
                withParent(
                    allOf(
                        withId(R.id.secondary),
                        withParent(withId(android.R.id.content))
                    )
                ),
                isDisplayed()
            )
        )
        editText.check(matches(withText("Cake")))

        val editText2 = onView(
            allOf(
                withId(R.id.f_cuisine), withText("pastry"),
                withParent(
                    allOf(
                        withId(R.id.secondary),
                        withParent(withId(android.R.id.content))
                    )
                ),
                isDisplayed()
            )
        )
        editText2.check(matches(withText("pastry")))

        val editText3 = onView(
            allOf(
                withId(R.id.f_date), withText("10/22/2021"),
                withParent(
                    allOf(
                        withId(R.id.secondary),
                        withParent(withId(android.R.id.content))
                    )
                ),
                isDisplayed()
            )
        )
        editText3.check(matches(withText("10/22/2021")))

        val editText4 = onView(
            allOf(
                withId(R.id.f_date), withText("10/22/2021"),
                withParent(
                    allOf(
                        withId(R.id.secondary),
                        withParent(withId(android.R.id.content))
                    )
                ),
                isDisplayed()
            )
        )
        editText4.check(matches(withText("10/22/2021")))

        pressBack()

        val imageView2 = onView(
            allOf(
                withId(R.id.one), withContentDescription("choco_cake"),
                withParent(
                    allOf(
                        withId(R.id.linearLayout),
                        withParent(IsInstanceOf.instanceOf(android.view.ViewGroup::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        imageView2.check(matches(isDisplayed()))

        val textView = onView(
            allOf(
                withId(R.id.c_name), withText("Cake"),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        textView.check(matches(withText("Cake")))

        val textView2 = onView(
            allOf(
                withId(R.id.c_rating), withText("2.5"),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("2.5")))

        val textView3 = onView(
            allOf(
                withId(R.id.c_rating), withText("2.5"),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        textView3.check(matches(withText("2.5")))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
