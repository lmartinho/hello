current_process = self()

spawn_link(fn -> 
    send(current_process, {:msg, "olá mundo"})
end)

receive do
    {:msg, contents} -> IO.puts(contents)
end
