# FS2020 Flight Scheduler

This will eventually produce an application that allows us to convert real life traffic from any source into traccic that can be used within Flight Simulator 2020. 

This is also going to be a demonstraction of a highly modular application and an implemntation of `:api` and `:implementation` modules. 

## How is the profect organised?

### `:apps` 

This module contains all modules that will produce an artifact to be consmed. That could be: a simple terminal application or even an Android application. 

### `:foundation`

This module contains all modules that should be reused across many features. The contents of these modules should be well abstracted and not contain leaky abstractions.

### `:features`

This module contains all of our features. These are modules that provide concrete functionality to our application.
