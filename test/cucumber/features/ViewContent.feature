Feature: View content via the Web UI 

    @ignore
    Scenario: Steve wants to see all available content
        Given that there are 20 items of content
        When Steve opens the content page
        Then display 20 items of content
