# Выводим информацию о ядрах и потоках
echo "Cores: $(grep -c ^processor /proc/cpuinfo)"
echo "Threads: $(grep -c ^processor /proc/cpuinfo)"

# Выводим информацию об ОЗУ
meminfo=( $(grep -E 'MemTotal|MemFree' /proc/meminfo | awk '{print $2}') )
mem_total_kb=${meminfo[0]}
mem_free_kb=${meminfo[1]}
mem_total_mb=$((mem_total_kb / 1024))
mem_free_mb=$((mem_free_kb / 1024))
echo "Memory: Total: ${mem_total_mb}MB, Free: ${mem_free_mb}MB"