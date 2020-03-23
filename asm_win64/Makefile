# Launch from Developer Command Prompt
all: hello

hello:
	nasm -f win64 -o hello.obj hello.asm
	link hello.obj /subsystem:console /entry:main /out:hello_basic.exe

clean:
	rm hello.obj hello