
## expect 模板
----
```expect
#!/usr/bin/expect
set force_conservative 0  ;

set timeout 1200;
set ip     [lindex $argv 0]
set pwd   [lindex $argv 1]

spawn /bin/bash
match_max 100000
expect -exact "#"
spawn ssh -o ConnectTimeout=10 -o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null  -o NumberOfPasswordPrompts=2  -l root -p 22  $ip
expect {
        "*yes/no*"
        {
                send "yes\r"
                expect "*assword*"
                send "$pwd\r"
        }
        "*assword*"
        { send "$pwd\r"}
        "ssh: Could not resolve hostname"
        { exit 2 }
        "Connection timed out"
        { exit 3 }
        "*Permission denied*"
        { exit 4 }

}
expect {
	"*assword*" { send "$pwd\r" }
	"#"         { send " \r" }
}
expect "#" { send "whoami\r" }
expect "#" { send  "exit\r"  }
```
