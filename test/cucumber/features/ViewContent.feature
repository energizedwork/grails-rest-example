Feature: View content via the Web UI 

    Steve wants to view all content so that he can
    review, edit and delete it.

    @IgnoreRest
    Scenario: Steve wants to see all available content
        Given that there are 20 items of content
        When Steve opens the content page
        Then display all items of content
