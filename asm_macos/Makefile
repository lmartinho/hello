all:
	nasm -f macho32 -O0 hello_32.asm
	ld hello_32.o -o hello_32
	nasm -f macho64 -O0 hello_64.asm
	ld hello_64.o -o hello_64

clean:
	rm hello_32.o hello_32
	rm hello_64.o hello_64