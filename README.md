# file-system-notifier

Send email with list of modified files in directory

[![Build Status](https://travis-ci.org/matthewsiemens/clojure-yahoo-finance.svg?branch=master)](https://travis-ci.org/matthewsiemens/clojure-file-change-notifier)
[![Dependency Status](https://www.versioneye.com/user/projects/56f8387635630e0034fda557/badge.svg)](https://www.versioneye.com/clojure/file-change-notifier:file-change-notifier/)
[![Clojars Project](https://img.shields.io/clojars/v/file-change-notifier.svg)](https://clojars.org/file-change-notifier)

## Usage

** Update config file **

You can either update the existing config file or create a new one

```
{
 :host "smtp.gmail.com"
 :user "" <- Add gmail username
 :pass "" <- Add password
 :ssl true
 :from "" <- Add address email will come from
 :to "" <- Add email address email should be sent too
 :subject "Files Changed" <- Set email subject to something informative
 :watch-directory "/backups" <- Set which directory to check for changed files
 :interval-in-minutes 1440 <- Set how many minutes in the past we should be checking for changes in
 }
```

## License

Copyright © 2016 Matthew Siemens

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
