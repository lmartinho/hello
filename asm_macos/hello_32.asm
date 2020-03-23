; Write msg to stdout
; user_ssize_t write(int fd, user_addr_t cbuf, user_size_t nbyte);
; @see: https://opensource.apple.com/source/xnu/xnu-3248.60.10/bsd/kern/syscalls.master.auto.html
global start

section .text
start:
    push dword msg.len ; user_size_t nbyte
    push dword msg     ; user_addr_t cbuf
    push dword 1       ; int fd
    mov eax, 4         ; the system interprets 4 as "write"
    sub esp, 4         ; required for BSD, so can do the int 0x80 without copying args around
    int 0x80           ; call kernel function (passes control to the interrupt handler @see: https://en.wikipedia.org/wiki/Interrupt_vector_table)
    add esp, 16        ; ?

    push dword 0       ; rval
    mov eax, 1         ; exit
    sub esp, 12        ; (for BSD, see above)
    int 0x80           ; call kernel function

section .data
msg:    db  "Olá, mundo!", 10
.len:   equ $ - msg