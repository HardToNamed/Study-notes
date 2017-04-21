远程ssh登录执行命令

set ip     [lindex $argv 0] 根据位置参数设置变量

#!/usr/bin/expect
set timeout 10
spawn ssh 128.128.168.11
expect "*assword*"
send "Huawei123\r"
expect "#"
send "ls\r"
expect "#"
send "exit\r"
expect eof


2
#!/usr/bin/expect
# ./exec_shell.sh ip user passwd order
set timeout 30

set ip     [lindex $argv 0]
set user   [lindex $argv 1]
set passwd [lindex $argv 2]
set order  [lindex $argv 3]

proc do_commod { commod } {
        expect {
                "#" { send "$commod\r" }
                ">" { send "$commod\r" }
                "]" { send "$commod\r" }
                "*assword*" {  exit 5}
                "Permission denied" {  exit 6}
        }
}

set number 0

spawn ssh -o ConnectTimeout=10 -o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null  -o NumberOfPasswordPrompts=1  -l $user -p 22  $ip
expect {
        "*yes/no*"
        {
                send "yes\r"
                expect "*assword*"
                send "$passwd\r"
        }
        "*assword*"
        { send "$passwd\r"}
        "ssh: Could not resolve hostname"
        { exit 2 }
        "Connection timed out"
        { exit 3 }
        "*Permission denied*"
        { exit 4 }

}
do_commod "$order"
do_commod "exit"
exit 0
