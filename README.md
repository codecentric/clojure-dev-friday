# clojure-dev-friday

This repository contains examples and stubs for getting to know Clojure.

## Prerequisites
- Java 1.6+
- A Clojure IDE
- Leiningen

### Editors/IDE
Clojure support is available for several IDEs. Traditionally, Emacs was the first choice for working with Lisps
including Clojure. Nowadays, other tooling has advanced sufficiently to dodge the Emacs learning curve.

To be able to work efficiently with Clojure, your tool should support at least these functionalities:
- integrated REPL (a sort of command line console into your program)
- support to compile current Clojure source file and load into REPL
- paredit/structural edit: keeps all those parenthesis balanced so you don't have to count them

Some possible choices that fulfill these criteria:
- [Emacs + nREPL](https://github.com/overtone/emacs-live): pre-configured setup, all the Emacs pros and cons apply
- [Eclipse + Counterclockwise](http://doc.ccw-ide.org/): allows debugging Clojure code, rainbow parenthesis
- [LightTable](http://www.lighttable.com): fairly new editor that comes with a live REPL
- [IntelliJ + Cursive](https://cursiveclojure.com/userguide/): debugger, auto-imports, initial refactoring support

More options (I haven't used so far): vim-fireplace, Atom, Catnip...

I personally used Emacs for several years which provides a very productive Clojure development environment,
but switched to IntelliJ + Cursive (+ Emacs keymap) this year, which in my opinion is
the most advanced tool in the Clojure space. It is still in "Early Access Program" status, so some things are broken
from time to time, but development is very active and reported issues are taken care of quickly. I especially like
well-known Java IDE features like "Find Usages", "Unused variable", super-fast auto-completion, auto-import of Java classes (and also
of Clojure namespaces as of lately) and extensive structural editing support (more on that later).
For those preferring Eclipse, Counterclockwise provides a solid solution as well that brings the needed base-features.
LightTable (written in ClojureScript) tries to make the Clojure workflow even more interactive by providing an Instarepl that immediately displays
the results of Clojure expression in the editor. Definitely worth a try, but new territory for me as well.

Choose your preferred tool and follow the installation instructions given there.

### Leiningen: Project/Dependency/Build Management

[Leiningen](http://leiningen.org/) is the de-facto standard tool to deal with Clojure projects.

Please follow the [installation instructions](http://leiningen.org/#install).

## Getting started

Try to familiarize yourself with how to compile/load the current file into the REPL, change into the namespace
of the current file etc. Ideally, set-up hotkeys for structural-editing/paredit.


## License

Copyright Gerrit Hentschel, codecentric AG © 2014

Distributed under the Eclipse Public License version 1.0.
