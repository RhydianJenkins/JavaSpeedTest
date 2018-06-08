# JavaSpeedTest
Small script that tests the conventional loop, Java 8 stream / parallelStream, and the Collections class to see the speed of each in finding an object in a set with the maximum variable.

Example output:

Creating objects...
Created 1000000 objects in 244 miliseconds.

========== Run 1: ==========

[Loop]			39 ms.
[Stream]		78 ms.
[ParallelStream]	298 ms.
[Comparator]		36 ms.

========== Run 2: ==========

[Loop]			23 ms.
[Stream]		18 ms.
[ParallelStream]	6 ms.
[Comparator]		34 ms.

========== Run 3: ==========

[Loop]			17 ms.
[Stream]		19 ms.
[ParallelStream]	6 ms.
[Comparator]		25 ms.

========== Run 4: ==========

[Loop]			19 ms.
[Stream]		18 ms.
[ParallelStream]	8 ms.
[Comparator]		24 ms.

Finshed.
