
As part of a background thread, the JVM frees memory that isn't being referenced by anything in the program.

A protected Object method called "finalize" is called by the GC to free its memory. It can also be used manually.