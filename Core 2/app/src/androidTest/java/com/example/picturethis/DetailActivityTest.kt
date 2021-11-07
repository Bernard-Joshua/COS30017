package com.example.picturethis


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.*
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
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class DetailActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun detailActivityTest() {
        val appCompatImageView = onView(
            allOf(
                withId(R.id.two), withContentDescription("muffins"),
                childAtPosition(
                    allOf(
                        withId(R.id.linearLayout),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatImageView.perform(click())

        val appCompatEditText = onView(
            allOf(
                withId(R.id.f_name), withText("Muffin"),
                childAtPosition(
                    allOf(
                        withId(R.id.secondary),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText.perform(replaceText("Cupcake"))

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.f_name), withText("Cupcake"),
                childAtPosition(
                    allOf(
                        withId(R.id.secondary),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText2.perform(closeSoftKeyboard())

        val appCompatEditText3 = onView(
            allOf(
                withId(R.id.f_cuisine), withText("pastry"),
                childAtPosition(
                    allOf(
                        withId(R.id.secondary),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText3.perform(replaceText("Baked"))

        val appCompatEditText4 = onView(
            allOf(
                withId(R.id.f_cuisine), withText("Baked"),
                childAtPosition(
                    allOf(
                        withId(R.id.secondary),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText4.perform(closeSoftKeyboard())

        val appCompatEditText5 = onView(
            allOf(
                withId(R.id.f_date), withText("10/22/2021"),
                childAtPosition(
                    allOf(
                        withId(R.id.secondary),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        appCompatEditText5.perform(replaceText("11/25/2021"))

        val appCompatEditText6 = onView(
            allOf(
                withId(R.id.f_date), withText("11/25/2021"),
                childAtPosition(
                    allOf(
                        withId(R.id.secondary),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        appCompatEditText6.perform(closeSoftKeyboard())

        pressBack()

        val textView = onView(
            allOf(
                withId(R.id.m_name), withText("Cupcake"),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        textView.check(matches(withText("Cupcake")))

        val textView2 = onView(
            allOf(
                withId(R.id.m_name), withText("Cupcake"),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("Cupcake")))

        val appCompatImageView2 = onView(
            allOf(
                withId(R.id.four), withContentDescription("croissants"),
                childAtPosition(
                    allOf(
                        withId(R.id.linearLayout2),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            5
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatImageView2.perform(click())

        val appCompatEditText7 = onView(
            allOf(
                withId(R.id.f_name), withText("Croissant"),
                childAtPosition(
                    allOf(
                        withId(R.id.secondary),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText7.perform(replaceText(""))

        val appCompatEditText8 = onView(
            allOf(
                withId(R.id.f_name),
                childAtPosition(
                    allOf(
                        withId(R.id.secondary),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText8.perform(closeSoftKeyboard())

        val appCompatEditText9 = onView(
            allOf(
                withId(R.id.f_cuisine), withText("pastry"),
                childAtPosition(
                    allOf(
                        withId(R.id.secondary),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText9.perform(replaceText(""))

        val appCompatEditText10 = onView(
            allOf(
                withId(R.id.f_cuisine),
                childAtPosition(
                    allOf(
                        withId(R.id.secondary),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText10.perform(closeSoftKeyboard())

        val appCompatEditText11 = onView(
            allOf(
                withId(R.id.f_date), withText("10/22/2021"),
                childAtPosition(
                    allOf(
                        withId(R.id.secondary),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        appCompatEditText11.perform(replaceText(""))

        val appCompatEditText12 = onView(
            allOf(
                withId(R.id.f_date),
                childAtPosition(
                    allOf(
                        withId(R.id.secondary),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        appCompatEditText12.perform(closeSoftKeyboard())

        val editText = onView(
            allOf(
                withId(R.id.f_name),
                withParent(
                    allOf(
                        withId(R.id.secondary),
                        withParent(withId(android.R.id.content))
                    )
                ),
                isDisplayed()
            )
        )
        editText.check(matches(withText("")))

        val editText2 = onView(
            allOf(
                withId(R.id.f_cuisine),
                withParent(
                    allOf(
                        withId(R.id.secondary),
                        withParent(withId(android.R.id.content))
                    )
                ),
                isDisplayed()
            )
        )
        editText2.check(matches(withText("")))

        val editText3 = onView(
            allOf(
                withId(R.id.f_date),
                withParent(
                    allOf(
                        withId(R.id.secondary),
                        withParent(withId(android.R.id.content))
                    )
                ),
                isDisplayed()
            )
        )
        editText3.check(matches(withText("")))

        val editText4 = onView(
            allOf(
                withId(R.id.f_date),
                withParent(
                    allOf(
                        withId(R.id.secondary),
                        withParent(withId(android.R.id.content))
                    )
                ),
                isDisplayed()
            )
        )
        editText4.check(matches(withText("")))

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

        val viewGroup2 = onView(
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
        viewGroup2.check(matches(isDisplayed()))
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
